import logo from './logo.svg';
import './App.css';
import React from 'react';
import {Container, Grid, TextField, Typography, Card, CardContent} from '@mui/material';
import NpcController from '../npc/NpcController';


class App extends React.Component {
    render(){
      return (
        <Grid container className="App">
            <Grid item xs={12}>
                <Typography align="center" variant="h3">NPC Writing Prompts</Typography>
            </Grid>
            <Grid item xs={2}>
            </Grid>
            <Grid item xs={10}>
                <NpcController></NpcController>
            </Grid>
        </Grid>
      );
    }
}

export default App;
