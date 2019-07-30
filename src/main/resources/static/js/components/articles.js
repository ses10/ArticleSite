var Articles = React.createClass({
	getInitialState: function(){
		return{
			currentPage: 0,
			pageSize: 10
		};
	},
	
	componentDidMount: function(){
		this.fetchArticles();
	},
	
	fetchArticles: function(){
		fetch("http://localhost:8080/articles?page=" + this.state.currentPage + "&size=" + this.state.pageSize)
		.then(response => response.json())
		.then(json => console.log(json));
	},
	
	handlePrevClick: function(){
		if(this.state.currentPage > 0)
			this.setState({currentPage: this.state.currentPage - 1}, () => this.fetchArticles());
	},
	
	handleNextClick: function(){
		this.setState({currentPage: this.state.currentPage + 1}, () => this.fetchArticles());
	},
	
	render: function(){
		return (
			<div>
				<h1>Articles</h1>
				<button onClick={this.handlePrevClick}>Prev</button>
				<button onClick={this.handleNextClick}>Next</button>
			</div>
		);
	}
	
});