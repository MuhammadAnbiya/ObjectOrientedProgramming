
import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidasiUmur{
    
    public void cekUmur(int umur)  throws ValidasiException  {
        if(umur < 17) {
            throw new ValidasiException("Anda letik keneh");
        }
    }

    public static void main(String[] args) {
        ValidasiUmur uv = new ValidasiUmur();
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("umur: ");
            int umur = sc.nextInt();
            uv.cekUmur(umur);
        }catch(InputMismatchException ie){
            System.out.println("input Anda Salah!");
        }
        catch (ValidasiException e) {
            System.out.println(e.getMessage());
        }
        finally{
            sc.close();
        }
    }

}
