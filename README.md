# demoSpringProject

Not: 
> 4.Sorunun Cevabı Alttadır.

- H2 Database
- Spring Data Jpa
- Spring Web
- Lombok
- Builder
- JPQL
- Maven

Kullanarak geliştirdiğim içerisinde Resftul Web Servis mimarisi olan bir demo proje. 
OOP ve çoklu katman mimarisi ile geliştirdiğim bu projede şirket ve çalışan şeklinde 2 Entity oluşturup bunları DTO yapısı ile maskeleyerek çalıştırdım.
Testlerini Talend Api Tester ile gerçekleştirdiğim bir porje oldu. İllaki Eksiklerim vardır. Ancak yaptığım denemelerde sorunsuz olarak çalıştı..

Maalesef ki içerisinde Abstract Class yapısı,kişileştirilmiş hata yönetimi, ResponseEntity<>, General Enumeration yapısını kullanma fırsatım olmadı. 
Çok fazla vaktim olmadığı için ben de gereksiz uzatmak istemedim. Bu konuları da barındıran önceden hazırladığım örnek projem de mevcut, linkimi ekliyorum.
[Gelişmis Demo Proje](https://github.com/mesutcalim/CRM-LITE/tree/pair8/crm-lite/src/main/java/com/etiya/crmlite/entities)

##Question4
```
public class Question4
{
    public static void main(String[] args) {

        for(int i=0;i<12;i+=2){
            if(i==0){
                System.out.print("*");
            }
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
```
