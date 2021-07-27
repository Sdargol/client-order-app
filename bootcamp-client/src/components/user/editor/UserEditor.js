import { useParams } from "react-router-dom"

export const UserEditor = () => {
    let {login} = useParams('login');
    return (
        <div>
             <h1>UserEditor</h1>
            {login}
        </div>
   )
}