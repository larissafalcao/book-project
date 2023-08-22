import {useState, useEffect} from 'react';
import { Breadcrumb, Layout, Menu, theme } from 'antd';
import axios from 'axios';
import {List, Typography} from 'antd';

const { Header, Content, Footer } = Layout;
const App = () => {
  const [books, setBooks] = useState([])
  const apiPath = "http://localhost:8080/api"

  useEffect(() => {
    axios.get(apiPath.concat('/book'))
      .then(function (response) {
        setBooks(response.data)
      })
      .catch(function (error) {
        console.error(error);
      });
  
  }, [])
  

  const {
    token: { colorBgContainer },
  } = theme.useToken();


  return (
    <Layout className="layout">
      <Header
        style={{
          display: 'flex',
          alignItems: 'center',
        }}
      >
        <div className="demo-logo" />
        <Menu
          theme="dark"
          mode="horizontal"
          wid
          defaultSelectedKeys={['2']}
          items={new Array(1).fill(null).map((_, index) => ({
            key: String(index + 1),
            label: `home`,
          }))}
        />
      </Header>
      <Content
        style={{
          padding: '0 50px',
        }}
      >
        <Breadcrumb
          style={{
            margin: '16px 0',
          }}
        >
          <Breadcrumb.Item>Home</Breadcrumb.Item>
          <Breadcrumb.Item>List</Breadcrumb.Item>
          <Breadcrumb.Item>App</Breadcrumb.Item>
        </Breadcrumb>
        <div
          className="site-layout-content"
          style={{
            background: colorBgContainer,
          }}
        >
        {/* <Descriptions title="Books Info" items={books[0]} /> */}

        <List
          header={<div>Livros Cadastrados</div>}
          bordered
          dataSource={books}
          renderItem={(item) => (
            <List.Item>
              <Typography.Text mark>[ID]</Typography.Text> {item.id}
              <Typography.Text mark> [NOME]</Typography.Text> {item.name}
              <Typography.Text mark> [CATEGORIA]</Typography.Text> {item.category.name}
              <Typography.Text mark> [EDITORA]</Typography.Text> {item.editora}
              <Typography.Text mark> [EDIÇÃO]</Typography.Text> {item.edition}
              <Typography.Text mark> [ISBN]</Typography.Text> {item.isbn}
              <Typography.Text mark> [LANGUAGE]</Typography.Text> {item.language}
              <Typography.Text mark> [AUTORES]</Typography.Text> {item.authors.map(function(author){
   return author.name + " | ";
})}
            </List.Item>
          )}
        />
        

        </div>
      </Content>
      <Footer
        style={{
          textAlign: 'center',
        }}
      >
        Ant Design ©2023 Created by Ant UED
      </Footer>
    </Layout>
  );
};
export default App;