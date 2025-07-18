import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, UrlTree } from '@angular/router';
import { CategorieserviceService } from '../shared/categorieservice.service';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {
  categories: Array<any>=[];
  Souscategories: Array<any>=[];
  constructor(private CategorieService: CategorieserviceService, private router: Router) {}

   allO(){
    this.CategorieService.getAllO().subscribe(data => {
      this.categories = data;
      
    });
   }
   getSousCategories(parent_id: number) {
    this.CategorieService.getSousCatégoriesO(parent_id).subscribe(
      (data) => {
        this.Souscategories = data;
        console.log(this.Souscategories)
      },
      (error) => console.log(error)
    );
  }

   ngOnInit() {
    this.allO();
  }
  public menus=[
    "/menu1",
    "/menu2",
    "/menu3",
    "/menu4",
    "/menu5",
    "/menutout"
  ]
  items = [
    'shirt-outline',
    'color-wand-outline',
    'home-outline',
    'color-palette-outline',
    'library-outline',
    'layers-outline'    
  ];


}
