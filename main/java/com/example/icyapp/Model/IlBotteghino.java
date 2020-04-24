package com.example.icyapp.Model;

public class IlBotteghino {
    private String menu_id,food_id,name_id,image_id;

    public IlBotteghino() {

    }
    //prezzo

    public IlBotteghino(String menu_id, String food_id, String image) {
        this.menu_id = menu_id;
        this.food_id = food_id;
        this.name_id = name_id;
        this.image_id = image_id;
    }
    public String getMenu_id() {
        return menu_id;
    }
    public void setMenu_id(String menu_id){

        this.menu_id = menu_id;
    }

    public String getFood_id() {
        return food_id;
    }

    public void setFood_id(String food_id){
        this.food_id = food_id;
    }

    public String getImage() {
        return image_id;
    }
    public void setImage_id(String image_id){
        this.image_id =image_id;
    }

    public String getName_id(){
        return name_id;
    }
    public void setName_id(String name_id){
        this.name_id=name_id;
    }

}
