package com.coldraincn.laimihui.Alipay;

/**
 * Created by hd on 2017/9/10.
 */

public class AliSetting {
    public static final String APPID = "2017082808421167";
    // 商户PID
    public static final String PARTNER = "2088411962251465";
    // 商户收款账号
    public static final String SELLER = "caiwu@wecity.co";
    // 商户私钥，pkcs8格式
    public static final String RSA2_PRIVATE = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCB\n"+
            "KcwggSjAgEAAoIBAQCWqk2cImKCxi0LTFtD1wo9BhDehBlxWzNGTLyTMEUG6gRH7X/f\n"+
            "nwOWNvhbtcDPUeptHCATA0LO5b7TEuI9yaTahMPMKY5tglGLK8aCKPTdcDCWmoQ7RA3\n"+
            "RBydi1uqOjxA3ozbLVo+X1Yi09OdIzQMjSUYhIzi2LUDNAdPcmiQRl5REkDtA+hTczC\n"+
            "JeNxuUMDMbC3cZ31UIvGapfDVwjjXaLRYYW4/ynD4H2aeDpAyZ8GtI2YWYtfGGGjblY\n"+
            "gfhBi+FtMggP2J7o8jWt72q9sblS7m3yjTcSrQdEEyX7GnPpbZBVAFTVRULrfwRXliKJ\n"+
            "gnFX3DigRjrpqXCOjPy9gxRAgMBAAECggEAAPofwLh0XRa96gnXuavmVBj6+QZwR8zomz\n"+
            "caLfYtLGtOFc1Te/bDBjFbEPUvx+hnFcgN6TGnOEJDJ4lC0FXDbOtZfbRzSQCEWNuy0Nt\n"+
            "FIz58Ai4EV4IMeOOL/NcZ9Ey3NTUowM7R5ZEr7sh7y3wQ3iS2gLaCwqOufOXbIt4ZB8gqU\n"+
            "DsIpWTyk7C1oZGUw33CrfjnUQIMNnYom9vUbYW/3F0PYjXckFS+TiVxU1gtBTiBlB+OxQa2\n"+
            "7JTOd6X0UEgBdJwL0jo9o5QxeKTPjSBDG3AEqySgDLOJodOs90Eue8tTNOzgsam7AD5Ovuc\n"+
            "lTOvU/e0QtmTz4Te6Glwn2SEm8QKBgQDNdwgEfxHihPr2S/afDWuAoGyvbm9L9zf52He/FJ\n"+
            "2jrAXFAo8fSARA9onNr8j2/7B/iHR1sU9ZhxbpOua6mxIwl4RaP40Hu5ZvMyjpHkn1tsP3Nk\n"+
            "rmfp6w2vQYqgiy0PvdA8GBLcXqKI6mvE56Q5ZsjVJ2A2fB43XnpNfXmTyJHQKBgQC7uNfMfE\n"+
            "div9oDi8yiblvI7VGBP2WplwQU3MzfjwhvLP8chHvcXx1T33fsoPTEC8b4BZVQmzZvddazMI1\n"+
            "lOba24TzRtBXSuiEylYiwckivoYER61WgsQuWA0eydyMenTKVBhrclVdZ4u/BBtJOReD77yGtf\n"+
            "lJl/PuK3MbUDAVdxQKBgGDC/fOgJDwZhFcZzzt4hng9FPJJgAC2nJX9a+eBPfwmt1Dgs6Z3tAkk\n"+
            "EiHb9zjbkbN9/9qtdkEjbZbJNoALJ7XapWobI7/QiDg2T735lbsyJ3f1CbEjUHjZpLs42H/eC78\n"+
            "6VZcQh3SPRR8g75SE4AKfS4ZodCTLimtdJolSkT/BAoGAYDPgU+k05ESRw9N3MZ8A5r3IUUZeIUVF\n"+
            "UDO/wqoYlnEm5ER4/Xy5GOyjFt990KKAe0bROJfyk7h+KSKus7uaCarwcj+qF25P6Q59GH/ZBDjuXn\n"+
            "KOVWWmHGDd83Xex6ej7n9McNMQCv6kA/Ys/PQO0s3AIptkOuQlPQrb0nu+nEkCgYEAsXDSxYuOZPYDb\n"+
            "psHakwNP+7aB4MV+IP/ho71KeP+utSsD/2jwLq+2Qi6uxEut8FQLrre2YrU4+weEJqwyc6WQTHg0VTch\n"+
            "3OeoZFzmaMVSVWERu+lorwCWKcmRbBKSRP3+2gGYoAXX37YXMj4oFYmrk0gNAM0r/0d9equpDTx6SY=";
    public static final String RSA_PRIVATE = "";
    // 支付宝公钥
    public static final String RSA_PUBLIC = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAk0VxGxeWSlbVkRa3S5MM74CbaVkGJCFdfQQGfXIIDLPgvYLtoawvnNf2UnsxvgmTXY+1YSZ58T/qZ+bZBp81jNBxr0cPsKgGS7h/tcTA6MkKIO9S/DbfkzuXUJXyN0f50uRhwST9TeBa7K1eiHEVZBFTWiBewhqu6mhJJUw71Nm0k6e6vVaDh3hTMjy4XJ39DTSLyoXGdsPR1UUtYtEX2zHTsSwpXhCaKqjdIc96xUX8Gg3OHHab63JCm7Nyj0Beeg6fk2ZinKJMDuOtAx7ypwXJNSEsb+tHCU6P6g9Apvsp0UdhUYb1YMe9YGEUtef/fAX0Wigbj9ArRAWSOVF9kQIDAQAB";
    // private static final int SDK_PAY_FLAG = 1;
}
