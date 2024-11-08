package org.example;

public class FindBestTimeBuySellStocks {

    public static void main(String[] args) {
        int final_sell=0, final_profit=0,cur_buy=0,cur_sell=0,cur_profit=0;
        int[] arr=new int[] {7,1,5,3,6,4};
        int final_buy=arr[0];


        for (int i=1; i< (arr.length-1); i++ )
        {
            cur_buy = arr[i-1];
            cur_sell=arr[i];

            if(cur_buy<final_buy)
            {
                final_buy=cur_buy;
            }

            cur_profit=cur_sell-final_buy;

            if(cur_profit>final_profit)
            {
                final_sell=cur_sell;
                final_profit=cur_profit;
            }
        }
        System.out.println("final_sell: "+ final_sell +" final_profit:  "+final_profit+" final_buy:"+final_buy);

    }
}
