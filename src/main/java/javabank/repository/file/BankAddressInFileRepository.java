package javabank.repository.file;

import javabank.domain.BankAddress;
import javabank.domain.validators.Validator;

// 파일로부터 BankAddress 정보를 읽고 쓰는 리포지토리 클래스입니다.
public class BankAddressInFileRepository extends AbstractInFileRepository<Long, BankAddress> {
    /**
     * 새로운 BankAddressInFileRepository를 생성하는 생성자입니다.
     * @param fileName  String, 데이터가 로드되거나 저장될 파일의 이름
     * @param validator Validator<BankAddress>, BankAddressFileRepository의 유효성 검사기
     */
    public BankAddressInFileRepository(String fileName, Validator<BankAddress> validator) {
        super(fileName, validator);
    }

    /**
     * 지정된 속성 목록을 사용하여 BankAddress를 추출합니다.
     * @param attributes String[], 추출할 BankAddress의 속성
     * @return BankAddress, 주어진 속성을 기반으로 추출된 BankAddress
     */
    @Override
    public BankAddress extractEntity(String[] attributes) {
        BankAddress bankAddress = new BankAddress(attributes[1], Integer.parseInt(attributes[2]), attributes[3], attributes[4],
                Integer.parseInt(attributes[5]), attributes[6]);
        bankAddress.setId(Long.parseLong(attributes[0]));
        return bankAddress;
    }

    /**
     * CSV 저장을 위해 BankAddress 엔티티를 문자열 배열로 변환합니다.
     * @param entity BankAddress, 속성 목록을 결정할 엔티티
     * @return String[], 속성 목록
     */
    @Override
    public String[] createEntityAsStringList(BankAddress entity) {
        return new String[]{entity.getId().toString(), entity.getStreetName(), String.valueOf(entity.getNumber()), entity.getCityName(),
                entity.getCountyName(), String.valueOf(entity.getPostalCode()), entity.getCountryName()};
    }
}