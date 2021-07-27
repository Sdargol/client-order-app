import { useHistory } from 'react-router-dom';
import './Card.css';

export const Card = ({login, name}) => {
    let history = useHistory();
    
    const handleEditor = () => history.push(`/user/${login}`);
    
    return (
        <div className="App-user-card">
            <div className="App-user-card-wrapper">
                <img className="App-user-avatar" src="/user.svg" alt="avatar" />
                <p>{login}</p>
            </div>
            <div className="App-user-card-wrapper-push">
                <p>{name}</p>
            </div>
            <div className="App-user-card-wrapper App-user-card-group-btn">
                <button onClick = {handleEditor}><img className="App-user-card-btn" src="/pencil.svg" alt="pencil" /></button>
                <div className="App-user-card-separator" />
                <button><img className="App-user-card-btn" src="/delete.svg" alt="delete" /></button>
            </div>
        </div>
    );
}