public class ProfitLoss {
    public static void main(String[] args) {
        int SellingPrice = 191;
        int CostPrice = 129;
        int Profit = SellingPrice-CostPrice;
        double ProfitPercentage = (double) Profit / CostPrice * 100 ;
        System.out.println(
                "The Cost Price is INR " + CostPrice + " and Selling Price is INR " + SellingPrice + "\n" +
                        "The Profit is INR " + Profit + " and the Profit Percentage is " + ProfitPercentage);

    }
}
