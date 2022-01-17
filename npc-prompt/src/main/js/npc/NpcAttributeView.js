import React from 'react';
import Container from '@mui/material/Container';
import TextField from '@mui/material/TextField';
import Typography from '@mui/material/Typography';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import PropTypes from 'prop-types';
import NpcAttribute from './NpcAttribute'

class NpcAttributeView extends React.Component {

    constructor(props) {
        super(props);
	}

	render(){
	    let {label, attribute, onChange, value} = this.props;
	    return (
	    <Container align="left" sx={{p:0.5}}>
            <div>
                <TextField fullWidth multiline maxRows={4} label={label} onChange={onChange} value={value}></TextField>
            </div>
            <Typography variant="caption">{attribute.text}</Typography>
        </Container>);
	}
}

NpcAttributeView.propTypes = {
      onChange: PropTypes.func,
      value: PropTypes.string,
      label: PropTypes.string,
      attribute: PropTypes.instanceOf(NpcAttribute)
    };

export default NpcAttributeView;