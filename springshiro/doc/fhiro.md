


#会话
登录成功后使用Subject.getSession()即可获取会话；其等价于Subject.getSession(true)，
即如果当前没有创建Session对象会创建一个；另外Subject.getSession(false)，
如果当前没有创建Session则返回null
（不过默认情况下如果启用会话存储功能的话在创建Subject时会主动创建一个Session）。