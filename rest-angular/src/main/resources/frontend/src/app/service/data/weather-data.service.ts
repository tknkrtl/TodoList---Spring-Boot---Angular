import { Injectable } from '@angular/core';
import { HttpClient } from '@Angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class WeatherDataService {

  url:string;
  urlEnd:string;
  API_KEY: string;
  icon;
  iconUrl;
  iconUrlEnd;


  constructor(private http:HttpClient) {

    this.url = "https://api.openweathermap.org/data/2.5/weather?q=";
    this.urlEnd= "&units=metric";
    this.API_KEY= "155370ae9c6a51a52b7455c69310bf1b";
    this.iconUrl= "http://openweathermap.org/img/w/"
    this.iconUrlEnd =".png"

   }

   getWeather(city){

    return (this.http.get(this.url+city+this.urlEnd+"&APPID="+this.API_KEY));
    
   }
   getIcon(icon){

     this.icon = this.iconUrl + icon + this.iconUrlEnd;
     return this.icon;

   }





}
