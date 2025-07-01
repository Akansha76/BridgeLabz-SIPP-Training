package Inheritance;

class Book{
   String title="";
   int PublicationYear;

   Book(String title,int PublicationYear){
       this.title=title;
       this.PublicationYear=PublicationYear;
   }

}
class Author extends Book{
    String name="";
    String bio="";

    Author(String title,int PublicationYear,String name,String bio){
        super(title,PublicationYear);
        this.name=name;
        this.bio=bio;
        
    }
  
    void AuthorInfo(){
        System.out.print("Author name "+name+"\nAuthor bio "+bio+"\ntitle:"+title+"\nBio:"+bio);
    }

}


public class library {
    public static void main(String[] args) {
        Author a1=new Author("The sun in the east",2011,"Harry","Difficult");
        a1.AuthorInfo();
    }
}