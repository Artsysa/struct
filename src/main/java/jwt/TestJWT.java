package jwt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import sun.security.rsa.RSAPublicKeyImpl;

import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.*;
import java.util.concurrent.TimeUnit;

/*
 * @describe:
 * @author: lyq
 * @date: 2020/7/28 14:09
 */
public class TestJWT {
    @Data
    @ToString
    @AllArgsConstructor
    static class User implements Serializable {
        String name;
        String id;
        Integer age;
    }
    public static void main(String[] args) throws InterruptedException {
        String secret="secret";//假设服务端秘钥
        Algorithm algorithm = Algorithm.HMAC256(secret);
        //jwt 头部信息
        Map<String,Object> map=new HashMap<>();
        map.put("alg","lyq");
        map.put("typ","lyq");
        User user = new User("张三", UUID.randomUUID().toString().substring(0, 5), 10);
        String s = JSON.toJSONString(user);
        Date nowDate = new Date();
        Date expireDate = AddDate(nowDate,1);//120 分钟过期

        String token= JWT.create()
                .withHeader(map)
               // .withIssuer("SERVICE") //对应 paylaod iss 节点：签发人
                .withClaim("user",s)
                .withIssuedAt(nowDate)//对应 paylaod iat 节点：生效时间
                .withExpiresAt(expireDate) //对应 paylaod  exp 签发人 节点：过期时间
                .sign(algorithm);
        System.out.println(token);
     //   Thread.sleep(2000);
        verifyJWTToken(token);
    }

    /**
     * 时间加减法
     * */
    private static Date AddDate(Date date,Integer minute){
        if(null==date)
            date=new Date();
        Calendar cal=new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.SECOND, minute);
        return cal.getTime();

    }

    private static void verifyJWTToken(String token) throws JWTVerificationException {
        try {
            Algorithm algorithm=Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm)
                  //  .withIssuer("SERVICE")
                    .build();

            DecodedJWT jwt =verifier.verify(token);
            String subject=jwt.getSubject();
            Map<String, Claim> claims=jwt.getClaims();
            Claim claim = claims.get("user");
            System.out.println(claim.asString());
        } catch (Exception e) {
            System.out.println("token expired");
        }

    }
}
