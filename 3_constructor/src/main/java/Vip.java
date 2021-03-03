public class Vip {
    private String person;

    public Vip(){
        System.out.format("Vip无参数构造");
    }
    public void setName(String name) {
        this.person = name;
    }

    public String getName() {
        return person;
    }
}
