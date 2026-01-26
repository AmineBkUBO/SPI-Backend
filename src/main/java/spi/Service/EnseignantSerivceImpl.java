package spi.Service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import spi.Service.Interface.EnseignantSerivce;

@Transactional
@Service
public class EnseignantSerivceImpl implements EnseignantSerivce {
}
