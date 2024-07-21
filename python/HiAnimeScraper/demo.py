# demo.py
import requests
from bs4 import BeautifulSoup


# constents
HI_ANIME_ADDRESS = "https://hianime.to/home"


class Hi_Anime():
	def __init__(self):
		self.home = "https://hianime.to/home"

	def get_all_popular(self):
		pass


response_data = requests.get(HI_ANIME_ADDRESS).content

soup = BeautifulSoup(response_data, 'html.parser')

links = soup.find_all('a')
just_addresses = []
for link in links:
    just_addresses.append(link.get('href'))

print(just_addresses)
