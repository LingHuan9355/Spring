package com.hr.spring.tx.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hr.spring.tx.dao.BookShopDao;
import com.hr.spring.tx.exception.UserAccountException;

/**
 * 
 * @Name  : BookShopServiceImpl
 * @Author : LH
 * @Date : 2018~{Dj~}6~{TB~}28~{HU~} ~{OBNg~}11:08:31
 * @Version : V1.0
 * 
 * @Description :
 */
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

			@Autowired
			private BookShopDao bookShopDao;
			
			//~{Lm<SJBNqW"=b~}
			//1~{!"J9SC~}propagation ~{V86(JBNq5D4+2%PPN*#,<451G0JBNq7=7(1;AmMbR;8vJBNq7=7(5wSCJ1~}
			//~{Hg:NJ9SCJBNq#,D,HOH!V5~} REQUIRED ~{#,<4J9SC5wSC7=7(5DJBNq~}
			//REQUIRES_NEW:~{J9SCWT<:5DJBNq#,5wSC5DJBNq7=7(5DJBNq1;9RFp~}
			//2~{!"J9SC~} isolation ~{V86(JBNq5D8t@k<61p#,Wn3#SC5DH!V5~}  READ_COMMITTED
			//3~{!"D,HOGi?vOB~} Spring ~{5DIyCwJ=JBNq6TKySPTKPPJ1Rl3#=xPP;X9v#,R2?IRTM(9}6TS&5DJtPT=xPPIhVC!#~}
			//~{M(3#Gi?vOBH%D,HOV5<4?I~}.
			//4~{!"J9SC~}readOnly ~{V86(JBNqJG7qN*V;6A#,1mJ>Ub8vJBNqV;6AH!J}>]#,2;8|PBJ}>]#,~}
			//~{UbQy?IRT0oVzJ}>]?bR}GfSE;/JBNq!#HtUf5DJGR;8vV;6AJ}>]?bV55D7=7(#,S&IhVC~}readOnly=true
			//5~{!"J9SC~} timeout ~{V86(JBNqG?VF;X9vV.G0JBNq?IRTU<SC5DJ1<d~}
			@Transactional(propagation =Propagation.REQUIRES_NEW,
									isolation = Isolation.READ_COMMITTED,
									readOnly = false,timeout=3)
			@Override
			public void purchase(String username, String isbn) {
				
					try {
						Thread.sleep(5000);//~{3,9}~}5~{CkJBNqG?VF;X9v~}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				
					//1.~{;qH!Ji5D5%<[~}
					int price = bookShopDao.findBookPriceByIsbn(isbn);
				
					//2.~{8|PBJi5D?b4f~}
					 bookShopDao.updateBookStock(isbn);
				
					//3.~{8|PBSC;'5DS`6n~}
					 bookShopDao.updateUserAccount(username, price);
			}

}
