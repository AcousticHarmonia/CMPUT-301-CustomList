package com.example.simpleparadox.listycity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities){
        super(context,0, cities);
        this.cities = cities;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * This function will get the size of the list
     * @return
     */
    @Override
    public int getCount(){
        return cities.size();
    }

    /**
     * This function will add a city object to the list
     * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * Return true or false if the City List contains specific city
     * @param city
     *      City to check if it exists in list
     * @return
     *      True or false whether city is present in list
     */
    public boolean hasCity(City city) {

        for (int i = 0; i < cities.size(); i++){
            if (cities.get(i).getCityName() == city.getCityName()){
                if (cities.get(i).getProvinceName() == city.getProvinceName()){
                    return true;
                }
            }
        }//end for
        if (cities.contains(city)){
            return true;
        }
        return false;

    }//end hasCity

    /**
     * Deletes city from the list if it exists in list
     * @param city
     *      City to delete
     */
    public void delete (City city){

        boolean success = false;

        if (cities.contains(city)){
            cities.remove(city);
            success = true;
        } else {
            for (int i = 0; i < cities.size(); i++) {
                if (cities.get(i).getCityName() == city.getCityName()) {
                    if (cities.get(i).getProvinceName() == city.getProvinceName()) {
                        cities.remove(cities.get(i));
                        success = true;
                        break;
                    }
                }
            }//end for
        }//end if

        if (!success){
            throw new IllegalArgumentException();
        }

    }//end delete

    /**
     * Returns integer of how many cities are in the list
     * @return
     *      How many cities are in list
     */
    public int countCities() {

        return cities.size();

        //return 0;
    }//end countCities

}







