class RunDataAnalysis < ActiveRecord::Base
	belongs_to :repository
	belongs_to :run_analysis
	has_many :run_data_analysis_data_configs

	def to_param
  		return self.run_analysis.to_param
	end

  def self.all(session, *args)
	if session
		return self.find(:all, :conditions => ["repository_id = ?",Repository.find_by_basePath(session[:repository_id]).id])
	else
		return super.all
	end
  end
end
