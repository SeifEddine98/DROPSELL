import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { concatMap, switchMap, tap } from 'rxjs';
import { CategorieserviceService } from '../shared/categorieservice.service';
import { StoreserviceService } from '../shared/storeservice.service';
import { GouvernoratDelegationserviceService } from '../shared/gouvernorat-delegationservice.service';

@Component({
  selector: 'app-addstore',
  templateUrl: './addstore.page.html',
  styleUrls: ['./addstore.page.scss'],
})
export class AddstorePage implements OnInit {
  categories: Array<any>=[];
  gouvernorats: Array<any>=[];
  delegations: Array<any>=[];
  categorie: any = {};
  fileInput: any;
  logo: File=new File([], "");
  couverture: File=new File([], "");
  user_id: number;
  partner_id: number;
  store_id: number;
  categorie_id: number;
  parent_id: number;
  store: any = {};
  selectedFileName: any;
  selectedFileName2: any;
  selectedCategorie: any;
  selectedSousCategorie: any;
  sousCategoriesOptions: Array<any> = [];

  constructor(private storeService: StoreserviceService,private CategorieService: CategorieserviceService,
    private route: ActivatedRoute,private gouvernoratdelegationsService: GouvernoratDelegationserviceService,
    private router: Router) { 
    this.user_id = 1;
    this.partner_id = 0;
    this.store_id = 0;
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
    this.allGouveDel();
  }

  all(){
    this.CategorieService.getAll().subscribe(data => {
      this.categories = data;
    });
   }
   allGouveDel(){
    this.gouvernoratdelegationsService.getAll().subscribe(data => {
      this.gouvernorats = data;
    });
   }
  onGouvernoratChange() {
    this.gouvernoratdelegationsService.GetDelegationsByGouvernorat(this.store.gouvernorat).subscribe(data => {
      this.delegations = data;
    });
  }
  
  onLogoSelected(event: Event) {
    const input = event.target as HTMLInputElement;
    this.selectedFileName = input.files![0].name;
    if (event?.target instanceof HTMLInputElement) {
      const files: FileList | null = event.target.files;
      if (files && files.length > 0) {
        this.logo = files[0];
      }
    }
  }

  onCouvertureSelected(event: Event) {
    const input = event.target as HTMLInputElement;
    this.selectedFileName2 = input.files![0].name;
    if (event?.target instanceof HTMLInputElement) {
      const files: FileList | null = event.target.files;
      if (files && files.length > 0) {
        this.couverture = files[0];
      }
    }
  }

  onSubmit() {
    this.storeService.addPartner(this.user_id).pipe(
      switchMap(user_id => {
        console.log(user_id);
        return this.storeService.getPartnerIdByUserId(this.user_id);
      }),
      switchMap(partner_id => {
        this.partner_id = partner_id;
        return this.storeService.addStore(this.logo, this.couverture, this.partner_id, this.store);
      }),
      switchMap(store => {
        console.log(store);
        return this.storeService.getStoreIdByPartnerId(this.partner_id);
      }),
      switchMap(store_id => {
        this.store_id = store_id;
        return this.CategorieService.GetCategoriesIdByName(this.selectedCategorie);
      }),
      switchMap(categorie_id => {
        this.categorie_id = categorie_id;
        return this.storeService.addStores_Categories(this.store_id, this.categorie_id);
      }),
      tap(result => {
        console.log(result);
        this.router.navigate(['/store']);
      })
    ).subscribe(
      result => console.log(result) ,
      error => console.error(error)
    );
  }
}
