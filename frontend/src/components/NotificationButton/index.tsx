import axios from 'axios';
import { useEffect } from 'react';
import { toast } from 'react-toastify';
import icon from '../../assets/img/notification-icon.svg';
import { BASE_URL } from '../../utils/request';
import './styles.css';

type Props = {
    saleId: number;
}

function NotificationButton( {saleId} : Props) {

    function handleClick(id: Number){
        axios.get(`${BASE_URL}/sales/${saleId}/notification`)
            .then(res => {
                toast.info("SMS enviado com sucesso")
            })
    }

    return(
        <div className="dsmeta-red-btn" onClick={() => handleClick(saleId)}>
            <img src={icon} alt="Notificar" />
        </div>
    )
}

export default NotificationButton