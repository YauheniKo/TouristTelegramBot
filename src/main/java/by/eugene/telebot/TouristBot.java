package by.eugene.telebot;



import by.eugene.telebot.entity.City;
import by.eugene.telebot.service.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
public class TouristBot extends TelegramLongPollingBot {


    @Autowired
    private CityServiceImpl cityService;

    public String getBotUsername() {
        return "@nicetourist_bot";
    }

    public String getBotToken() {
        return "1506353894:AAGHXIzWBZb2wyeom1Cwray5rLk2N1EaA_E";
    }

    public void onUpdateReceived(Update update) {
       String res = update.getMessage().getText();
       String start = "/start";
        SendMessage message = new SendMessage();

          List<City> cityList = cityService.getAllCities();
          City cit=null;
          for (City city:cityList){
              if(city.getName().equalsIgnoreCase(res)){
                  cit=city;
              }
          }
          if(start.equalsIgnoreCase(res)){
              message.setText("Добро пожаловать. Введите название города который Вас интересует ");
          }
          else if(cit!=null){
              message.setText(cit.getDescription());
          }else {
              message.setText("нет такого города");
          }


       message.setChatId((update.getMessage().getChatId()).toString());

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }

}
