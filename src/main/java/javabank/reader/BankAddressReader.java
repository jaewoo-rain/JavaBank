package javabank.reader;

import javabank.domain.BankAddress;

import java.io.IOException;

// System.in으로부터 BankAddress 정보를 읽어오는 클래스입니다.
public class BankAddressReader implements Reader<BankAddress>{
    /**
     * System.in으로부터 BankAddress 정보를 읽어옵니다.
     * @return BankAddress, 읽어온 BankAddress 객체
     * @throws IOException, 입출력 예외 발생 시
     */
    @Override
    public BankAddress read() throws IOException {
        System.out.println("은행 주소를 입력해주세요! ");
        Long idBankAddress = new ReaderID().read();

        String streetName;
        System.out.print("도로명: ");
        streetName = bufferedReader.readLine();

        int number;
        System.out.print("건물 번호: ");
        number = Integer.parseInt(bufferedReader.readLine());

        String cityName;
        System.out.print("도시: ");
        cityName = bufferedReader.readLine();

        String countyName;
        System.out.print("군/지역: ");
        countyName = bufferedReader.readLine();

        int postalCode;
        System.out.print("우편번호: ");
        postalCode = Integer.parseInt(bufferedReader.readLine());

        String countryName;
        System.out.print("국가: ");
        countryName = bufferedReader.readLine();

        BankAddress bankAddress = new BankAddress(streetName, number, cityName, countyName, postalCode, countryName);
        bankAddress.setId(idBankAddress);
        return bankAddress;
    }
}