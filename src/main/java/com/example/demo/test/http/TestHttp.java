package com.example.demo.test.http;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TestHttp {
    public static void main(String[] args) {
        String url = "";
        Map<String,String> param =  new HashMap<>(1);
        param.put("Cookie","qa_passport=aBCm4QdFLAg6VLE5yo4JQPGE-cFs_FtstmKqq0qJuAIUyBbBLykzGqKd10KCv40lXhcH4mtZNAnzpFkpU14uakSIB3V-dT-RAh63QMHN4XMD2X8zmWLJ2qE1n6YyK1VB1o7Mv2RONoNmxmLEiis0_CRRfj9JQO0_wrZN2rihP-s; dev_passport=Em73pQiTnpQ13e5apE2Nobnih2Xbv8yR0KyKOigdxeyntD2-oHmZUA_5Sbe9pDgUC7UIPBMrfxe8gZZbOIaByZEFiksOrGqpmKZH90I0sSr0aVnST5YoiOn6O2iWZg1H4HcAoKSc90pWFBNmYZBcScrlfNNEXM7GwiZwqhHgCJI; ymmoa_passport=XQxtaU7czIj9aXl8DEIFIdZ2Q5s1UBukoYyvfdEQbuI7hdSFL5CTOFIW9ZOmfCYdNNzCJBxJJ2EE9HkD2n_xUXVgemcEUSDAAAutMVUzeU8o1dGxd02O2AVxowbxJYnlQUsbu7WwuN7LvBppRlwOdVkcZ9X6VBFZUDIWNLFwykY; ymmoa_user={%22name%22:%22%E8%AF%B7%E4%B8%8D%E8%A6%81%E4%BD%BF%E7%94%A8%E6%AD%A4%20Cookie%22%2C%22avatarUrl%22:%22%22%2C%22departmentName%22:%22%E8%AF%B7%E4%B8%8D%E8%A6%81%E4%BD%BF%E7%94%A8%E6%AD%A4%20Cookie%22%2C%22id%22:10082%2C%22jobNumber%22:%22Y0010082%22}; _ssoSeed=1583397134025");
        String result = HttpClientUtil.getData(url,param);
        System.out.println(Optional.ofNullable(result).orElse("no thing"));
    }
}
