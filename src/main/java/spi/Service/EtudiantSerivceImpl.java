package spi.Service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import spi.Service.Interface.EtudiantSerivce;


@Transactional
@Service
public class EtudiantSerivceImpl implements EtudiantSerivce {
}
