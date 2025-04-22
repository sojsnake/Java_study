package lecture.book;

public class Book {
    //author, title, pageCount, coverType
    //필드
    String author;
    String title;
    int pageCount;
    String coverType;

    //생성자: 이름은 클래스명과 동일하게
//    생성자 메소드는 반환형을 작성하지 않는다.(작성하게되면 일반 메소드로 인식한다.)
//    객체 생성 시 반드시 실행됨

//    기본생성자(매개변수가 없는 생성자)
//    -> 매개변수 있는 생성자가 하나라도 있으면, compiler가 자동으로 기본생성자를 만들어주지 않는다.
    public Book() {
        System.out.println("기본 생성자 호출함 .....");
    }

//    오버로딩
//    -> 같은 이름의 메소드나 생성자를 매개변수의 갯수나 타입에 따라 여러 개 선언하는 것
    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public Book(String author, String title, int pageCount, String coverType) {
        this.author = author;
        this.title = title;
        this.pageCount = pageCount;
        this.coverType = coverType;
    }

    //메소드
    public String getTitle() {
        System.out.println(title + " 책의 작가는 " + author + "입니다.");
        return title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pageCount=" + pageCount +
                ", coverType='" + coverType + '\'' +
                '}';
    }
}
