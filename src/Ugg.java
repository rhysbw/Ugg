import java.util.Random;

public class Ugg
{
    enum UggRockSize{
        bigun(5),
        quitebigun(3),
        notsobigun(1);

        private final int multiplierVal;

        UggRockSize(int multiplierVal){
            this.multiplierVal = multiplierVal;
        }


        public int getMultiplierVal() {
            return multiplierVal;
        }
    }

    enum UggRockType{
        speckily(7),
        ouchyblack(20),
        floaty(2),
        hothothot(15);

        private final int multiplierVal;

        UggRockType(int multiplierVal){
            this.multiplierVal = multiplierVal;
        }


        public int getMultiplierVal() {
            return multiplierVal;
        }
    }
    public UggRockSize genSize(){
        Random rand = new Random();

        int int_random = rand.nextInt(9);
        if (0 < int_random && int_random < 6) {
            return UggRockSize.notsobigun;
        } else if (int_random >= 6 && int_random < 8) {
            return UggRockSize.quitebigun;
        }else{
            return UggRockSize.bigun;
        }
    }
    public UggRockType genType(){
        Random rand = new Random();

        int int_random = rand.nextInt(4);
        return switch (int_random) {
            case 0 -> UggRockType.floaty;
            case 1 -> UggRockType.hothothot;
            case 2 -> UggRockType.ouchyblack;
            case 3 -> UggRockType.speckily;
            default -> null;
        };
    }
    public UggRock drawRock(){
        return new UggRock(genSize(), genType());
    }
    public static class UggRock{
        public String getRockInfo(){
            return this.getRockSize().toString() + ", "+ this.getRockType().toString();
        }
        private final UggRockType rockType;
        private final UggRockSize rockSize;
        UggRock(UggRockSize rockSize, UggRockType rockType){
            this.rockType = rockType;
            this.rockSize = rockSize;
        }

        UggRockType getRockType() {
            return this.rockType;
        }

        UggRockSize getRockSize() {
            return this.rockSize;
        }

        int rockValue(){
            return this.getRockType().getMultiplierVal() * this.getRockSize().getMultiplierVal();
        }
    }
}
