import icon from '../../assets/img/notification-icon.svg'
import './styles.css'

function NotificationButton() {
    return(
        <div>
            <button className="dsmeta-red-btn">
                <img src={icon} alt="Notificar" />
            </button>
        </div>
    )
}

export default NotificationButton