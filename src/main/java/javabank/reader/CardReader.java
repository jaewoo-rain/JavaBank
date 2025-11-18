package javabank.reader;

import javabank.domain.Card;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// System.in으로부터 Card 정보를 읽어오는 클래스입니다.
public class CardReader implements Reader<Card>{
    /**
     * System.in으로부터 Card 정보를 읽어옵니다.
     * @return Card, 읽어온 Card 객체
     * @throws IOException, 입출력 예외 발생 시
     * @throws ParseException, 날짜 파싱 예외 발생 시
     */
    @Override
    public Card read() throws IOException, ParseException {
        System.out.println("카드 정보를 입력해주세요!");
        Long idCard = new ReaderID().read();

        String cardNumber;
        System.out.print("카드 번호: ");
        cardNumber = bufferedReader.readLine();

        String cardHolder;
        System.out.print("카드 소유자: ");
        cardHolder = bufferedReader.readLine();

        Date validThru;
        SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy", Locale.ENGLISH);
        String dateInString;
        System.out.print("만료일 (MM/YYYY): ");
        dateInString = bufferedReader.readLine();
        validThru = formatter.parse(dateInString);

        int cvvCode;
        System.out.print("CVV 코드: ");
        cvvCode = Integer.parseInt(bufferedReader.readLine());

        int PIN;
        System.out.print("PIN: ");
        PIN = Integer.parseInt(bufferedReader.readLine());

        Card card = new Card(cardNumber, cardHolder, validThru, cvvCode, PIN);
        card.setId(idCard);
        return card;
    }
}