public class Format {
    public static String chooseRublesEnding(double rubles){
        //окончания для рубля
        int floorRubles = (int) Math.floor(rubles);
        floorRubles = floorRubles > 19 ? floorRubles % 10 : floorRubles;
        if (floorRubles == 1)
            return "рубль";
        else if (floorRubles > 1  && floorRubles < 5)
            return  "рубля";
        else if(floorRubles > 4)
            return "рублей";
        else return "рублей";
    }

}
