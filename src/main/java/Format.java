public class Format {
    public static String chooseRublesEnding(double rubles){
        //окончания для рубля
        int floorRubles = (int) Math.floor(rubles);
        if (floorRubles == 1)
            return "рубль";
        else if (floorRubles > 1  && floorRubles < 5)
            return  "рубля";
        else return "рублей";
    }

}
