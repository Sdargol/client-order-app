import './InputField.css';

export const InputField = ({ val, handler, name }) => {
    return (
        <div className="User-editor-input-container">
            <label className="User-editor-input-label" htmlFor="username-input-id">{name}</label>
            <input onChange={handler}
                id="username-input-id"
                className="User-editor-input"
                type="input"
                placeholder="Username..."
                autoComplete="off"
                aria-label="New user name"
                value={val}/>
        </div>
    )
}