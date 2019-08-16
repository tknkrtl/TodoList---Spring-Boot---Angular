import { Component, OnInit,ViewEncapsulation } from '@angular/core';
import { WeatherDataService } from '../service/data/weather-data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class HomeComponent implements OnInit {

  city = "";
  description;
  weatherInfo=null;
  icon;
  temperature;
  windSpeed;
  humidity;
  pressure;

  constructor(private weatherService:WeatherDataService) { }

  ngOnInit() {
  }

  handleSearch(){
    this.weatherService.getWeather(this.city).subscribe(
      response => { this.weatherInfo=response;
                    this.description=this.weatherInfo.weather[0].description;
                    this.icon=this.weatherService.getIcon(this.weatherInfo.weather[0].icon);
                    this.temperature=this.weatherInfo.main.temp;
                    this.windSpeed=this.weatherInfo.wind.speed;
                    this.humidity=this.weatherInfo.main.humidity;
                    this.pressure=this.weatherInfo.main.pressure;                
                  }
      )
  }
  checkIfWeatherExists(){
    return !(this.weatherInfo===null);
  }
  
}
