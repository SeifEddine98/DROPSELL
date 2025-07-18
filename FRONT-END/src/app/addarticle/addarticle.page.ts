import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { concatMap, switchMap, tap } from 'rxjs';
import { CategorieserviceService } from '../shared/categorieservice.service';
import { ArticleserviceService } from '../shared/articleservice.service';
import { AlertController } from '@ionic/angular';

@Component({
  selector: 'app-addarticle',
  templateUrl: './addarticle.page.html',
  styleUrls: ['./addarticle.page.scss'],
})
export class AddarticlePage implements OnInit {
  f:boolean=true;
  promo: boolean;
  prixDT: any;
  prixInitial: any;
  prixVente: any;
  prix: any;
  categories: Array<any>=[];
  pointures: Array<any>=[];
  tailles: Array<any>=[];
  categorie: any = {};
  fileInput: any;
  picture: File=new File([], "");
  store_id: number;
  categorie_id: number;
  parent_id: number;
  article: any = {};
  status1: any ;
  status2: any ;
  status3: any ;
  status4: any ;
  status: any;
  x:any;
  y:any;
  z:any;
  selectedFileName: any;
  selectedSizeType: any;
  selectedCategorie: any;
  selectedSousCategorie: any;
  sousCategoriesOptions: Array<any> = [];
  pictureList: File[] = [];
  selectedFileNames: Array<any> = [];

  constructor(private articleService: ArticleserviceService,private CategorieService: CategorieserviceService,private route: ActivatedRoute,
    private router: Router, private alertController: AlertController) { 
      this.promo= false;
      this.store_id = 27;
      this.categorie_id = 0;
      this.parent_id = 0;
    }
    onSelectCategorie() {
      this.CategorieService.GetCategoriesIdByName(this.selectedCategorie)
      .pipe(
        concatMap(parent_id => this.CategorieService.getSousCatégories(parent_id))
      )
      .subscribe(data => {
        this.sousCategoriesOptions = data;
      });
    }
  ngOnInit() {
    this.all();
    this.allPointures();
    this.allTailles();
  }
  all(){
    this.CategorieService.getAll().subscribe(data => {
      this.categories = data;
    });
   }
   allPointures(){
    this.articleService.getPointures().subscribe(data => {
      this.pointures = data;
    });
   }
   allTailles(){
    this.articleService.getTailles().subscribe(data => {
      this.tailles = data;
    });
   }
    assignPrice(article: any, prix: number, prixVente: number, promo: boolean): void {
    if (promo) {
        article.price = prixVente;
      }
     else {
        article.price = prix;
    }
  }
  
   onToggleChange(name: string) {
    
    switch (name) {
      case 'status1':
        this.status = "new_with_tag";
        this.status2 = null;
        this.status3 = null;
        this.status4 = null;
        break;
      case 'status2':
        this.status = "new_without_tag";
        this.status1 = null;
        this.status3 = null;
        this.status4 = null;
        break;
      case 'status3':
        this.status = "very_good_condition";
        this.status1 = null;
        this.status2 = null;
        this.status4 = null;
        break;
      case 'status4':
        this.status = "good_condition";
        this.status1 = null;
        this.status2 = null;
        this.status3 = null;
        break;
      default:
        break;
    }
    
  }
  
  
  onPictureRemoved(i: number) {
    if (i >= 0 && i < this.selectedFileNames.length) {
      this.pictureList.splice(i, 1); // Supprimer le fichier de la liste
      this.selectedFileNames.splice(i, 1); // Supprimer le nom du fichier de la liste
    }
  }
  
  onPictureSelected(event: Event) {
    this.pictureList=[];
    const input = event.target as HTMLInputElement;
    if (event?.target instanceof HTMLInputElement) {
      const files: FileList | null = event.target.files;
      if (files && files.length > 0 && files.length <= 10) {
        this.selectedFileNames = [];
        // Traiter chaque fichier
        for (let i = 0; i < files.length; i++) {
          const file = files[i];
          this.pictureList.push(file);
          this.selectedFileNames.push(file.name);
          // Traiter le fichier ici
        }
      } else {
        // Afficher un message d'erreur
        this.presentAlert2(true);
        this.selectedFileNames = [];
      }
    }
  }
  async presentAlert2(reloadPage: boolean) {
    const alert = await this.alertController.create({
      header: 'Erreur',
      message: 'Vous avez depasser 10 photos ! Merci de refaire la saisie',
      buttons: [
        {
          text: 'OK',
          handler: () => {
          }
        },
      ]
    });
    await alert.present();
  }
  async presentAlert(reloadPage: boolean) {
    const alert = await this.alertController.create({
      header: 'Succès',
      message: 'L\'ajout de l\'article a été effectué avec succès.',
      buttons: [
        {
          text: 'Ajouter un autre article',
          handler: () => {
            // L'utilisateur veut ajouter un autre article
             if (reloadPage) {
              location.reload();
            }
          }
        },
        {
          text: 'Fermer',
          role: 'cancel',
          handler: () => {
            // L'utilisateur ne veut pas ajouter d'autre article
        
          }
        }
      ]
    });
  
    await alert.present();
  }
  
  
  onSubmit() {
    if (this.selectedSizeType === 'dimensions') {
      this.article.size = `${this.x} x ${this.y} x ${this.z}`;
    }
   
      this.assignPrice(this.article, this.prix, this.prixVente, this.promo);
  
      this.CategorieService.GetCategoriesIdByName(this.selectedCategorie).pipe(
        switchMap(category_id => {
          return this.articleService.addArticle(this.pictureList, category_id, this.store_id, this.status, this.article);
        })
      ).subscribe(
        result => {
          console.log(result);
          this.presentAlert(this.f);
        } ,
        error => console.error(error)
      );
    
  }
  
}
