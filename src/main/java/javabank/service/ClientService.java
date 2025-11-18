package javabank.service;

import javabank.domain.Client;
import javabank.domain.validators.ValidationException;
import javabank.repository.memory.InMemoryRepository;
import javabank.service.validators.ClientValidatorService;
import javabank.service.validators.ValidatorService;

import java.text.ParseException;

// Client와 관련된 비즈니스 로직을 처리하는 서비스 클래스입니다.
public class ClientService {
    private final InMemoryRepository<Long, Client> clientInMemoryRepository;
    private final ValidatorService<Client> clientValidatorService = new ClientValidatorService();

    /**
     * 새로운 ClientService를 생성하는 생성자입니다.
     * @param clientInMemoryRepository InMemoryRepository<Long, Client>, Client 데이터를 처리하는 리포지토리
     */
    public ClientService(InMemoryRepository<Long, Client> clientInMemoryRepository) {
        this.clientInMemoryRepository = clientInMemoryRepository;
    }

    /**
     * 새로운 Client를 추가합니다.
     * @param clientParam Client, 추가할 고객
     * @return  null, Client가 성공적으로 저장된 경우
     *          null이 아닌 Client, 그렇지 않은 경우 (예: 동일한 ID의 Client가 이미 존재)
     * @throws ValidationException, 추가하려는 Client가 유효하지 않을 경우
     * @throws ParseException, 파싱 예외 발생 시
     */
    public Client addClient(Client clientParam) throws ValidationException, ParseException {
        Client client = clientInMemoryRepository.save(clientParam);
        clientValidatorService.validateAdd(client);
        return client;
    }

    /**
     * Client를 삭제합니다.
     * @param clientIDParam, 삭제할 Client의 ID
     * @return  null, 삭제하려는 Client가 존재하지 않는 경우
     *          null이 아닌 Client, 삭제된 Client
     * @throws ValidationException, 삭제하려는 Client가 존재하지 않을 경우
     */
    public Client deleteClient(Long clientIDParam) throws ValidationException {
        Client client = clientInMemoryRepository.delete(clientIDParam);
        clientValidatorService.validateDelete(client);
        return client;
    }
}