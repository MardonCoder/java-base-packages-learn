import java.util.concurrent.*;

public class JavaParallelLearn extends RecursiveAction{
    private int id;

    JavaParallelLearn(int id){
        this.id = id;
    }

    @Override
    protected void compute(){
        System.out.printf("Привет, я созданный дочерный процесс под номером %d с помощью fork()\n", this.id);
    }

    public static void main(String[] args) {
        JavaParallelLearn jpl1 = new JavaParallelLearn(1);
        JavaParallelLearn jpl2 = new JavaParallelLearn(2);

        jpl1.fork();
        jpl2.fork();

        jpl1.join(); // ставлю этот поток на паузу, пока ap1 не закончит свою работу
        jpl2.join(); // ставлю поток, в котором вызывается этот метод на паузу, пока ap2 не завершится

        jpl1.reinitialize();
        jpl1.fork();
        jpl1.join();

        System.out.println("Я сработаю как только все действия закончатся");
    }
}
