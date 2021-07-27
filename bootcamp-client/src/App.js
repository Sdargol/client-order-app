import './App.css';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import { Users } from './components/user/Users';
import { UserEditor } from './components/user/editor/UserEditor';

export const App = () => { 
  return (
    <Router>
        <Switch>
          <Route path="/user/:login">
            <UserEditor></UserEditor>
          </Route>
          <Route path="/">
            <Users></Users>
          </Route>
        </Switch>
    </Router>
  );
}