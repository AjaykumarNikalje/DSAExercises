package org.example.binarySearch;

public class AllocateMinimumNumberOfPages {

  public static boolean isvalid(int[] arr,int mid,int m)
  {
    int students=1;
    int sum=0;
    for(int i=0;i<arr.length;i++)
    {
        sum=sum+arr[i];

        if( sum >  mid)
        {
            students++;
            sum=arr[i];
        }

        if(students>m)
        {
            return false;
        }
    }
      return true;
  }

    public static void main(String[] args)
    {
        int[] pages = {12, 34, 67, 90};
        int m=2;

        int start=0;
        int end=0;
        int response=-1;
        for(int i=0;i<pages.length;i++)
        {
            end=end+pages[i];
        }
        System.out.println("sum "+end);

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(isvalid(pages,mid,m))
            {
                response=mid;
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
        }
        System.out.println(" Student 1 has to read " + response +" pages.");

    }
}
