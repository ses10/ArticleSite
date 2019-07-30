var Articles = React.createClass({
	getInitialState: function(){
		return{
			currentPage: 0,
			pageSize: 10,
			articles: []
		};
	},
	
	componentDidMount: function(){
		this.fetchArticles();
	},
	
	fetchArticles: function(){
		fetch("http://localhost:8080/articles?page=" + this.state.currentPage + "&size=" + this.state.pageSize)
		.then(response => response.json())
		.then(json => this.setState( {articles: json} ));
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
				<ul>
					{this.state.articles.map((item, index) => (
							<li key={item.id}>{item.by}</li>
					))}
				</ul>
				<button onClick={this.handlePrevClick}>Prev</button>
				<button onClick={this.handleNextClick}>Next</button>
			</div>
		);
	}
	
});