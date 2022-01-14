import logo from './logo.svg';
import './App.css';
import React from 'react';
import Npc from '../npc/Npc';

class App extends React.Component {
    render(){
      return (
        <div className="App">
          <Npc></Npc>
        </div>
      );
    }
}

export default App;
