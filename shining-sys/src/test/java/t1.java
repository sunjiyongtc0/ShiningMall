import com.sjy.shining.utils.Constant;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.junit.Test;

public class t1 {


    @Test
    public void t1(){
       String t = new Sha256Hash(Constant.DEFAULT_PASS_WORD).toHex();
        System.out.println(t);
    }
}
