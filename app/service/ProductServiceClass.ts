import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Merchant } from "../model/Merchant";
import { Product } from "../model/Product";



@Injectable({
    providedIn: 'root'
})
export class ProductService{
   

    private baseUrl = 'http://localhost:5000';

    constructor(private http: HttpClient){}

    getProductsList(): Observable<Product[]> {
        return this.http.get<Product[]>(`${this.baseUrl}`  + `/products/all/21`);
      }
    
      array: any[] = [];

      createProduct(product: Product): Observable<any> {
        console.log("add")
        return this.http.post<any>(this.baseUrl+"/products/add", product);
      }


      getMerchant(merchantId: number): Observable<Merchant>{
        return this.http.get<Merchant>(this.baseUrl+"/products/getmerchantbyid/"+merchantId);
      }
    
      updateProduct(product: Product): Observable<any> {
       return this.http.put<any>(this.baseUrl+"/products/update", product);
       
      }
    
}