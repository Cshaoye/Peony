package com.shaoye.utils;

import java.security.GeneralSecurityException;

import org.springframework.beans.BeanUtils;

import com.shaoye.dto.TBUserDto;
import com.shaoye.pojo.TBUser;
import com.shaoye.security.TextCipher;
import com.shaoye.security.impl.DESTextCipher;

/**
 * Dto转换器
 * @author hufan
 *
 */
public class DtoConverter {

	private static final String salt = "CreditCloudRock!";

	/**
	 * 使用beanutils转换
	 */
	public static TBUser convert(TBUserDto dto) {
		if(dto == null) {
			return null;
		}
		TBUser user = new TBUser();
		BeanUtils.copyProperties(dto, user);
		return user;
	}
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public static TBUser getTBUser(TBUserDto dto) {
		TBUser user = null;
		if(dto != null) {
			user = new TBUser(dto.getId(),dto.getMobile(),dto.getIdNumber());
		}
		return user;
	}
	/**
	 * 
	 * @param user
	 * @return
	 */
	public static TBUserDto getTBUserDto(TBUser user) {
		TBUserDto dto = null;
		if (user != null) {
			dto = new TBUserDto(user.getId(), user.getEmployeeId(),
					user.getEnabled(), user.getEnterprise(), user.getName(),
					user.getSource(), user.getPassphrase(), user.getSalt());
			TextCipher textCipher = new DESTextCipher();
			textCipher.init(salt);
			try {
				if (user.getIdNumber() != null) {
					dto.setIdNumber(textCipher.decrypt(user.getIdNumber()));
				} else {
					dto.setIdNumber(null);
				}
				if (user.getMobile() != null) {
					dto.setMobile(textCipher.decrypt(user.getMobile()));
				} else {
					dto.setIdNumber(null);
				}
			} catch (GeneralSecurityException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	
}
