public class User {
    private String name;

    public User(int num){
        System.out.format("活跃用户数量：%d万%n",num);
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
