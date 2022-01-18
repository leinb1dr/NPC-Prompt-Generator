import React from 'react';
import {Container, Grid, TextField, Typography, Box, Tabs, Tab} from '@mui/material';
import NpcAttributeView from './NpcAttributeView';
import TabPanel from './TabPanel';
import Npc from './Npc'

class NpcView extends React.Component {

    constructor(props) {
        super(props);
        this.state = {tabIndex: 0, npc: Npc.empty()};
	}

	handleChange = (event, newValue)=>{
	    this.setState({tabIndex: newValue});
	}

    render() {
      return (
      <Container>
        <Box sx={{ borderBottom: 1, borderColor: 'divider' }}>
          <Tabs value={this.state.tabIndex} onChange={this.handleChange} aria-label="basic tabs example">
            <Tab label="Edit" />
            <Tab label="Notes" />
          </Tabs>
        </Box>
        <TabPanel value={this.state.tabIndex} index={0}>
            <Container align="left" sx={{ p:1 }}>
                <Typography color='primary.dark' variant="h4">Occupation/History</Typography>
                <Typography label="body1">Tbd</Typography>
                <Container sx={{p:1}}></Container>

                <Typography color='primary.dark' variant="h4">Appearance</Typography>
                <NpcAttributeView
                    label="Appearance"
                    attribute={this.props.npc.appearance}
                    value={this.state.npc.appearance.text}
                    onChange={(event)=>{
                        let npc = this.state.npc;
                        npc.appearance.text=event.target.value;
                        this.setState({npc:npc})
                    }}></NpcAttributeView>
                <Container sx={{p:1}}></Container>

                <Typography color='primary.dark' variant="h4">Abilities</Typography>
                <Grid container className="App">
                    <Grid item xs={6}>
                        <NpcAttributeView
                            label="High Ability"
                            attribute={this.props.npc.highAbility}
                            value={this.state.npc.highAbility.text}
                            onChange={(event)=>{
                                let npc = this.state.npc;
                                npc.highAbility.text=event.target.value;
                                this.setState({npc:npc})
                            }}></NpcAttributeView>
                    </Grid>
                    <Grid item xs={6}>
                        <NpcAttributeView
                            label="Low Ability"
                            attribute={this.props.npc.lowAbility}
                            value={this.state.npc.lowAbility.text}
                            onChange={(event)=>{
                                let npc = this.state.npc;
                                npc.lowAbility.text=event.target.value;
                                this.setState({npc:npc})
                            }}></NpcAttributeView>
                       </Grid>
                </Grid>
                <Container sx={{p:1}}></Container>

                <Typography color='primary.dark' variant="h4">Personality</Typography>
                <Grid container className="App">
                    <Grid item xs={6}>
                        <NpcAttributeView
                            label="Talent"
                            attribute={this.props.npc.talent}
                            value={this.state.npc.talent.text}
                            onChange={(event)=>{
                                let npc = this.state.npc;
                                npc.talent.text=event.target.value;
                                this.setState({npc:npc})
                            }}></NpcAttributeView>
                        <NpcAttributeView
                            label="Interaction"
                            attribute={this.props.npc.interaction}
                            value={this.state.npc.interaction.text}
                            onChange={(event)=>{
                                let npc = this.state.npc;
                                npc.interaction.text=event.target.value;
                                this.setState({npc:npc})
                            }}></NpcAttributeView>
                        <NpcAttributeView
                            label="Mannerism"
                            attribute={this.props.npc.mannerisms}
                            value={this.state.npc.mannerisms.text}
                            onChange={(event)=>{
                                let npc = this.state.npc;
                                npc.mannerisms.text=event.target.value;
                                this.setState({npc:npc})
                            }}></NpcAttributeView>
                    </Grid>
                    <Grid item xs={6}>
                        <NpcAttributeView
                            label="Ideal"
                            attribute={this.props.npc.ideal}
                            value={this.state.npc.ideal.text}
                            onChange={(event)=>{
                                let npc = this.state.npc;
                                npc.ideal.text=event.target.value;
                                this.setState({npc:npc})
                            }}></NpcAttributeView>
                        <NpcAttributeView
                            label="Bond"
                            attribute={this.props.npc.bond}
                            value={this.state.npc.bond.text}
                            onChange={(event)=>{
                                let npc = this.state.npc;
                                npc.bond.text=event.target.value;
                                this.setState({npc:npc})
                            }}></NpcAttributeView>
                        <NpcAttributeView
                            label="Flaw"
                            attribute={this.props.npc.flaw}
                            value={this.state.npc.flaw.text}
                            onChange={(event)=>{
                                let npc = this.state.npc;
                                npc.flaw.text=event.target.value;
                                this.setState({npc:npc})
                            }}></NpcAttributeView>
                    </Grid>
                </Grid>

            </Container>
        </TabPanel>
        <TabPanel value={this.state.tabIndex} index={1}>
            <Container align="left" sx={{ p:1 }}>
                <Typography color='primary.dark' variant="h4">Occupation/History</Typography>
                <Typography label="body1">Tbd</Typography>
                <Container sx={{p:1}}></Container>

                <Typography color='primary.dark' variant="h4">Appearance</Typography>
                <Typography variant="body1">{this.state.npc.appearance.text}</Typography>

                <Container sx={{p:1}}></Container>

                <Typography color='primary.dark' variant="h4">Abilities</Typography>
                <Typography color='primary.dark' variant="h5">High Ability</Typography>
                <Typography variant="body1">{this.state.npc.highAbility.text}</Typography>
                <Typography color='primary.dark' variant="h5">Low Ability</Typography>
                <Typography variant="body1">{this.state.npc.lowAbility.text}</Typography>

                <Container sx={{p:1}}></Container>

                <Typography color='primary.dark' variant="h4">Personality</Typography>
                <Typography variant="body1">Talent: {this.state.npc.talent.text}</Typography>
                <Typography variant="body1">Interaction: {this.state.npc.interaction.text}</Typography>
                <Typography variant="body1">Mannerism: {this.state.npc.mannerisms.text}</Typography>
                <Typography variant="body1">Ideal: {this.state.npc.ideal.text}</Typography>
                <Typography variant="body1">Bond: {this.state.npc.bond.text}</Typography>
                <Typography variant="body1">Flaw: {this.state.npc.flaw.text}</Typography>

            </Container>
        </TabPanel>
      </Container>


      );
    }
}

export default NpcView