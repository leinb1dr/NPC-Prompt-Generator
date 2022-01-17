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
                <Typography label="body1">{this.props.npc.appearance.text}</Typography>
                <Container sx={{p:1}}></Container>

                <Typography color='primary.dark' variant="h4">Abilities</Typography>
                <Grid container className="App">
                    <Grid item xs={6}>
                        <NpcAttributeView label="High Ability" attribute={this.props.npc.highAbility}></NpcAttributeView>
                    </Grid>
                    <Grid item xs={6}>
                        <NpcAttributeView label="Low Ability" attribute={this.props.npc.lowAbility}></NpcAttributeView>
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

                        <NpcAttributeView label="Interaction" attribute={this.props.npc.interaction}></NpcAttributeView>
                        <NpcAttributeView label="Mannerism" attribute={this.props.npc.mannerisms}></NpcAttributeView>
                    </Grid>
                    <Grid item xs={6}>
                        <NpcAttributeView label="Ideal" attribute={this.props.npc.ideal}></NpcAttributeView>
                        <NpcAttributeView label="Bond" attribute={this.props.npc.bond}></NpcAttributeView>
                        <NpcAttributeView label="Flaw" attribute={this.props.npc.flaw}></NpcAttributeView>
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
                <Container sx={{p:1}}></Container>

                <Typography color='primary.dark' variant="h4">Abilities</Typography>

                <Container sx={{p:1}}></Container>

                <Typography color='primary.dark' variant="h4">Personality</Typography>
                <Typography variant="body1">Talent: {this.state.npc.talent.text}</Typography>


            </Container>
        </TabPanel>
      </Container>


      );
    }
}

export default NpcView