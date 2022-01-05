package com.chunkie.gdy.util;


import com.chunkie.gdy.common.Constants;
import com.chunkie.gdy.common.ResponseObj;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import io.jsonwebtoken.*;


import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

/**
 * @Description:
 * @ClassName: JwtUtil
 * @Author: SichengGuo
 * @Date: 2022/1/5 10:23
 * @Version: 1.0
 */
public class JwtUtils {
    /**
     * 签发JWT
     * @param id
     * @param name
     * @param ttlMillis
     * @return  String
     *
     */
    public static String createJWT(String id, String name, long ttlMillis) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        SecretKey secretKey = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setSubject(name)   // 主题
                .setIssuer("user")     // 签发者
                .setIssuedAt(now)      // 签发时间
                .signWith(signatureAlgorithm, secretKey); // 签名算法以及密匙
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate); // 过期时间
        }
        return builder.compact();
    }
    /**
     * 验证JWT
     * @param jwtStr
     * @return
     */
    public static ResponseObj validateJWT(String jwtStr) {
        ResponseObj checkResult = new ResponseObj();
        Claims claims = null;
        try {
            claims = parseJWT(jwtStr);
            checkResult.setCode(Constants.Code.NORMAL);
        } catch (ExpiredJwtException e) {
            checkResult.setCode(Constants.Code.EXCEPTION);
            checkResult.setMsg(Constants.Msgs.FAIL);
        } catch (SignatureException e) {
            checkResult.setCode(Constants.Code.EXCEPTION);
            checkResult.setMsg(Constants.Msgs.FAIL);
        } catch (Exception e) {
            checkResult.setCode(Constants.Code.EXCEPTION);
            checkResult.setMsg(Constants.Msgs.FAIL);
        }
        return checkResult;
    }
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.decode(Constants.JWT_SECRET);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     *
     * 解析JWT字符串
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }
}