import { Component, OnInit } from "@angular/core";
import { Product } from "../model/Product";
import { ProductService } from "../service/ProductServiceClass";
import { Merchant } from "../model/Merchant";
import { Router } from "@angular/router";



@Component({
    selector: 'add-comp',
    templateUrl: 'addProduct.html'
})

export class AddProductClass implements OnInit{
  ob: Product = new Product();
  submitted = false;
constructor(private  service: ProductService, private route:Router){}

productID: number;
productName: string;
merchantId: number;
tag: string;
company: string;
photo: string;
description: string;
quantity: number;
category: string;
subcategory: string;
soldQuantities: number;
price: number;
releaseDate: Date;
tags: string[]=[]
product: Product = new Product();

ngOnInit() {
}
AddData(){
  console.log("getmerchant")
  this.service.getMerchant(this.merchantId).subscribe(
    res=>{
      this.merchant = res;
      if(res == null){
        alert("Merchant not present")
      }else{
        this.product.productName = this.productName;
        this.product.merchant = this.merchant;
        this.product.company = this.company;
        this.tags.push(this.tag);
        this.product.tag = this.tags;
        this.product.photo = this.photo;
        this.product.description = this.description;
        this.product.quantity = this.quantity;
        this.product.category = this.category;
        this.product.subcategory = this.subcategory;
        this.product.soldQuantities = this.soldQuantities;
        this.product.price = this.price;
        this.product.releaseDate = this.releaseDate;
        this.service.createProduct(this.product).subscribe(
          res=>console.log(res),
          err=>console.log(err)
        )
      }
    }, err=>alert(err)
  )
}

merchant: Merchant;

newProduct(): void {
  this.service.getMerchant(this.merchantId).subscribe(
    res=>{
      this.merchant = res;
      console.log(this.merchant);
    }, err=>alert(err.message)
  ) 
}

onSubmit() {
  this.submitted = true;
  this.AddData();
}
gotoshowproduct(){
  this.route.navigate(['showProduct'])
}
}
  