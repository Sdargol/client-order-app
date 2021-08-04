import { InputField } from '../input/InputField';
import './OrderCard.css';

export const OrderCard = ({id, info}) => {
    return (
        <div className="Order-card">
            <div className ="Order-card-header">
                <h1>ID заказа: {id}</h1>
                <button><img className="Order-card-btn" src="/delete.svg" alt="delete" /></button>
            </div>
            <div className ="Order-card-header">
                <p>{info}</p>
            </div>
        </div>
    )
}