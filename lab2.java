import java.io.PrintStream;
import java.util.Scanner;
public class main {
  public static Scanner in = new Scanner(System.in);  // Объявляем объект класса Scanner для ввода данных
  public static PrintStream out = System.out;  // Объявляем объект класса PrintStream для вывода данных
  public static void main(String[] args) {
   int N = in.nextInt();//ввод N

   int[][] a = new int[N][];
   int[][] b = new int[N][];  //инициализируем массивы
   
   int sum_all = 0;
   int cnt_elements = 0;
   int max_M=0; //объявляем переменные
   for (int i = 0 ; i < a.length ; i++) {
      int M = in.nextInt();  //получаем размеры строчек в массивах
      a[i] = new int[M];
      b[i] = new int[M];
      cnt_elements = cnt_elements + M; //считаем общее количество элементов для ср. значения
      for (int j = 0 ; j < a[i].length ; j++) {
         a[i][j] = in.nextInt(); 
         b[i][j] = a[i][j]; //заполняем основной и запасной массив;
         sum_all = sum_all + a[i][j];  //считаем сумму для среднего значения 
      }
      if (M > max_M) {
         max_M = M; //для пирамиды ищем большую длину
      }
   }
   int sr_zhach = sum_all / cnt_elements; //считаем среднее арифметическое

   int A = in.nextInt();
   int B = in.nextInt();  //вводим границы диапазона 
   int max = -2147483648;
   int cnt = 0;
   int num = -1;
   int sum1=0;
   int sum2 = 0; //объявляем нужные переменные
   for (int k=0;k<(a.length-1);k++) {
      max = -2147483648;
      sum2 =-1;
      num = 0;
      for (int i = 0+k; i < a.length; i++) {
         cnt = 0; //обнуляем переменные для новой итерации 
         
         for (int j = 0 ; j < a[i].length ; j++) {
            if (a[i][j] >= A && a[i][j] <=B) {
               cnt++; //считаем кол-во элементов из диапазона в строчке
            }
         }
         if (cnt > max) { //сравниваем полученное количество с нынешним максимальным
            max = cnt;
            num = i;
            sum2= 0; //принимаем значения
            for (int j = 0 ; j < a[i].length ; j++) {
               if (a[i][j] < A || a[i][j]>B) {
                  sum2 =a[i][j] + sum2 ; //считаем сумму для равенства сравнения 
               }
            }
         } 
         else {
            if (cnt==max) {
               sum1 =0;
               for (int j = 0 ; j < a[i].length ; j++) {
                  if (a[i][j] < A || a[i][j]>B) {
                     sum1 =a[i][j] + sum1 ; //считаю сумму каждого кандидата в случае сравнения
                  }
               }
               if (sum1 >= sum2) { //сравниваем сумму, определяем наиболее подходящий элемент
                  sum2 = sum1;
                  num = i;
               }
            }
         }
         

      }
      int[] d = new int[a[k].length];
      d = a[k];
      a[k] = a[num];
      a[num] = d; //перестановка с третьим элементом
   }
   int cnt_srzhach = 0;
   int max_cnt_srzhach = 0;
   int num_cnt_srzhach = 0;  //объявляем переменные
   for (int i = 0 ; i < a.length ; i++) {
      cnt_srzhach = 0;  //обнуляем 
      for (int j = 0 ; j < a[i].length ; j++) {
        if (a[i][j] == sr_zhach) {
          cnt_srzhach++; //ищем количество элементов в строчке, совпадающих по значению со средним арифметическим
        } 
      }

      if (cnt_srzhach > max_cnt_srzhach) { //сравниваем, не больше ли оно нынешнего максимума
         max_cnt_srzhach = cnt_srzhach; 
         num_cnt_srzhach = i;
      }
   }
   out.println("Номер наибольшой строки: " + (num_cnt_srzhach+1));   //выводим номер наибольшей
   int max_length = 0;
   int num_lenght =-1;
   int max1 = 0;  //объявляем переменные 
   for (int k=b.length-1;k>=0;k--) { // сортируем запасной массив по кол ву элементов 
      max_length = 0;
      num_lenght = -1;
      for (int i = 0; i <= k; i++) {
         if (b[i].length > max_length) {  //сравниваем с нынешним максимумом
            max_length = b[i].length;
            num_lenght = i;
            max = 0;
            for (int j = 0; j <b[i].length; j++) {
               if (b[i][j] > max) { //смотрим макс. элемент, чтобы сравнить строчки в случае равенства элементов
                  max = b[i][j];
               }
            }
         } 
         else {
            if (b[i].length == max_length) { //сравниваем максимальные элементы в случае равенства
               max1 = 0;
               for (int j = 0; j <b[i].length; j++) {
                  if (b[i][j] > max1) {
                     max1 = b[i][j];  //ищем максимальный в новом кандидате
                  }
               }
               if (max1 > max) {
               max_length = b[i].length;
               num_lenght = i;
               }
            } 
         }
      }
      int[] d = new int[b[k].length];
      d = b[k];
      b[k] = b[num_lenght];
      b[num_lenght] = d; //делаем перестановку в начало
   }
   boolean dss = true;
   int das = -2312312;
   int cnt_lenght =0; 
   int cnt_lenght1 =0; //объявляем переменные
   for (int j = 0 ; j < b[0].length ; j++) {
      N = b[0][j];
      while (N >10) {
         cnt_lenght1++;
         N = N / 10; //считаем разряды для первой строчки
     }
   }
   for (int i =1; i <b.length;i++ ) { 
      cnt_lenght =0;
      for (int j = 0 ; j < b[i].length ; j++) {
         N = b[i][j];
         while (N >10) {
            cnt_lenght++;
            N = N / 10; //считаем разряды
        }
      }
      for (int p = 0; p < 1000; p++) {
      if ((b[i].length * p == b[i -1].length && cnt_lenght * p !=cnt_lenght1) || (b[i].length  == b[i -1].length*p && cnt_lenght* p !=cnt_lenght1* p)) { //сравниваем разряды для построения пирамиды, чтобы знать, нужно ли нам учитывать разницу в разрядах
         dss = false;
         cnt_lenght1 = cnt_lenght;
         break;
      }
   }
      
   }
   for (int i =0; i <b.length;i++ ) {
      for (int j = 0 ; j < b[i].length ; j++) {
         N = b[i][j];
         cnt_lenght =0;
         while (N >10) {
             cnt_lenght++;
             N = N / 10; //считаем разряды опять
         }
         if (cnt_lenght != das && das !=-2312312 && dss != false) {  // провеярем построчно
            dss = false;
            
            
            break; 
         }
         
         cnt_lenght = das;
      }
   }
   if (dss) {  
  for (int i =0; i <b.length;i++ ) {
      
      
      for(int ds = 0; ds < (max_M - b[i].length);ds++) {
          out.print(" "); //выставляем нужное количество элементов в зависимости от недостатка элементов до максимума
      }
      for (int j =0; j < b[i].length;j++ ) {
          out.print(b[i][j] + " "); //выводим сами элементы
      }
   
      
      out.println();
    }

   }
   else { //аналогично если проверки нету, просто учитываем разницу в разрядах 
      for (int i =0; i <b.length;i++ ) {
      
         cnt_lenght =0;
      for (int j =0; j < b[i].length;j++ ) {
          N = b[i][j];
          while (N >10) {
              cnt_lenght++;
              N = N / 10; //считаем опять разряды
          }
       }
         for(int ds = 0; ds < (max_M - b[i].length)-cnt_lenght;ds++) {
             out.print(" "); //выставляем нужное количество элементов в зависимости от недостатка элементов до максимума
         }
         for (int j =0; j < b[i].length;j++ ) {
             out.print(b[i][j] + " "); //выводим сами элементы
         }
      
         
         out.println(); //перенос на новую строчку
       }
      
   }
   for (int i =0; i <a.length;i++ )
 {
   for (int j =0; j < a[i].length;j++ ) {
    if (a[i][j] != 0) {
      a[i][j] = (int)(Math.log(Math.abs(a[i][j])) / Math.log(2)); //высчитываем логарифмы в соответствии с теоремой из-за отсутствия нужной функции
    }
    else {
      out.println("Логарифм нуля не определен, поэтому вместо него будет выведен нуль"); //нельзя логарифм от нуля
    }
 }
 }
 for (int i =0; i <a.length;i++ )
 {
   for (int j =0; j < a[i].length;j++ ) {
      out.print(a[i][j] + " "); //выводим массив
 }
 out.println(); //перенос на новую строчку
 }
}
}

